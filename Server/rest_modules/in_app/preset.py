from flask_restful import Resource
from flask import request

from support.mysql import query


class Preset(Resource):
    def get(self):
        # '내 프리셋' 리스트 데이터 가져오기
        # 필요한 데이터 : 프리셋 id, 이름, 소유여부, 업로드여부, 추가일

        email = request.args['email']
        data = query("SELECT preset_id, title, poss, uploaded, added_date FROM own_preset JOIN preset USING(preset_id) WHERE own_preset.owner='{0}'".format(email))
        # 충분한 데이터 조회를 위해 내 프리셋과 프리셋 테이블 join

        for index in range(len(data)):
            data[index]['added_date'] = str(data[index]['added_date'])
            # Serialize 오류 제거

            acc_data = query("SELECT nickname FROM account WHERE email='{0}'".format(email))
            if not acc_data:
                acc_data = query("SELECT nickname FROM account_sns WHERE email='{0}'".format(email))

            data[index]['nickname'] = acc_data[0]['nickname']
            # 닉네임 추가

        return data

    def post(self):
        # '내 프리셋'에 프리셋 만들어서 추가
        email = request.form['email']
        title = request.form['title']
        hash_tags = request.form['hash_tags']

        query("INSERT INTO preset(owner, title, uploaded, like_count, download_count, creation_date, hash_tags) VALUES('{0}', '{1}', 0, 0, 0, CURDATE(), '{2}')"
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
        # 필요한 데이터 : 프리셋 id, 이름, 업로드일
        email = request.args['email']
        data = query("SELECT preset_id, title, upload_date FROM preset JOIN market USING(preset_id) WHERE preset.owner='{0}' AND preset.uploaded=1".format(email))
        for index in range(len(data)):
            data[index]['upload_date'] = str(data[index]['upload_date'])
            # Serialize 오류 제거

        return data


class PresetDetail(Resource):
    def get(self):
        # 프리셋 세부 정보
        preset_id = request.args['preset_id']

        response = dict()

        preset_data = query("SELECT title, uploaded, like_count, download_count, creation_date, hash_tags FROM preset WHERE preset_id={0}".format(preset_id))[0]
        # preset_id, owner, title, uploaded, like_count, download_count, creation_date, hash_tags
        preset_data['creation_date'] = str(preset_data['creation_date'])

        market_data = query("SELECT is_free FROM market WHERE preset_id={0}".format(preset_id))[0]

        own_preset_data = query("SELECT owner, poss FROM own_preset WHERE preset_id={0}".format(preset_id))[0]
        # preset_id, owner, added_date, poss

        acc_data = query("SELECT nickname FROM account WHERE email='{0}'".format(own_preset_data['owner']))
        if not acc_data:
            acc_data = query("SELECT nickname FROM account_sns WHERE email='{0}'".format(own_preset_data['owner']))
        nickname = acc_data[0]['nickname']

        response.update(preset_data)
        response.update(market_data)
        response.update(own_preset_data)
        response['nickname'] = nickname

        return response
