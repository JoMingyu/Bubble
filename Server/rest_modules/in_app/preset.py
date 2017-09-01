from flask_restful import Resource
from flask import request

from support.mysql import query


class Preset(Resource):
    def get(self):
        # '내 프리셋' 데이터 가져오기
        email = request.args['email']
        data = query("SELECT * FROM own_preset WHERE owner='{0}'".format(email))
        return data

    def post(self):
        # '내 프리셋'에 프리셋 만들어서 추가
        email = request.form['email']
        title = request.form['title']
        hash_tags = request.form['hash_tags']

        query("INSERT INTO preset(owner, title, uploaded, like_count, download_count, creation_time, hash_tags) VALUES('{0}', '{1}', 1, 0, 0, CURDATE(), '{2}')"
              .format(email, title, hash_tags))

        new_preset_id = query("SELECT preset_id FROM preset ORDER BY preset_id DESC")[0]['preset_id']
        # insert와 함께 바로 새로운 preset id를 가져옴

        query("INSERT INTO own_preset VALUES('{0}', {1}, CURDATE(), 1)".format(email, new_preset_id))
        # 소유하고 있음을 뜻함

        exposure = request.form['exposure']
        contrast = request.form['contrast']
        highlight = request.form['highlight']
        blackpoint = request.form['blackpoint']
        white = request.form['white']
        black = request.form['black']
        temperature = request.form['temperature']
        tone = request.form['tone']
        chroma = request.form['chroma']
        query("INSERT INTO preset_options VALUES({0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9})"
              .format(new_preset_id, exposure, contrast, highlight, blackpoint, white, black, temperature, tone, chroma))

        return '', 201

    def delete(self):
        # 프리셋 제거
        preset_id = request.form['preset_id']
        if query("SELECT poss FROM own_preset WHERE preset_id='{0}'".format(preset_id))[0]['poss'] == 1:
            # 내가 만든 프리셋인 경우
            query("DELETE FROM preset WHERE preset_id='{0}'".format(preset_id))
            # fk cascade
        else:
            # 내가 만들지 않은 프리셋의 경우
            # '내 프리셋'에서만 삭제하고, 프리셋 리소스 테이블과 마켓에선 지우지 않음
            query("DELETE FROM own_preset WHERE preset_id='{0}'".format(preset_id))

        return '', 200


class UploadedPreset(Resource):
    def get(self):
        # '내 프리셋' 중 업로드된 것만 가져오기
        email = request.args['email']

        data = query("SELECT preset_id, title, upload_date FROM preset JOIN market using(preset_id) WHERE preset.owner='{0}' AND uploaded=1".format(email))

        for index in range(len(data)):
            data[index]['upload_date'] = str(data[index]['upload_date'])

        return data


class PresetDetail(Resource):
    def get(self):
        # 프리셋 세부 정보
        preset_id = request.args['preset_id']
        preset_data = query("SELECT * FROM own_preset JOIN preset_options using(preset_id) WHERE own_preset.preset_id={0}".format(preset_id))[0]
        preset_data['creation_time'] = str(preset_data['creation_time'])

        return str(preset_data)
