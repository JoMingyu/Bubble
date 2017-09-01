from flask_restful import Resource
from flask import request

from support.mysql import query
import json
from bson import json_util


class Preset(Resource):
    def get(self):
        # '내 프리셋' 데이터 가져오기
        email = request.args['email']
        data = query("SELECT * FROM own_preset WHERE owner='{0}'".format(email))
        return data

    def post(self):
        # '내 프리셋'에 추가
        email = request.form['email']
        title = request.form['title']
        query("INSERT INTO own_preset(owner, title, type, like_count, download_count, creation_time) VALUES('{0}', '{1}', 1, 0, 0, CURDATE())"
              .format(email, title))

        preset_id = query("SELECT preset_id FROM own_preset ORDER BY preset_id DESC")[0]['preset_id']
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
              .format(preset_id, exposure, contrast, highlight, blackpoint, white, black, temperature, tone, chroma))

        return '', 201

    def delete(self):
        # 프리셋 제거
        preset_id = request.form['preset_id']
        query("DELETE FROM own_preset WHERE preset_id={0}".format(preset_id))


class UploadedPreset(Resource):
    def get(self):
        # '내 프리셋' 중 업로드된 것만 가져오기
        email = request.args['email']

        data = query("SELECT * FROM own_preset WHERE owner='{0}'".format(email))
        response = list()

        for preset in data:
            if preset['type'] == 2:
                response.append(preset)

        return response


class PresetDetail(Resource):
    def get(self):
        # 프리셋 세부 정보
        preset_id = request.args['preset_id']
        preset_data = query("SELECT * FROM own_preset join preset_options using(preset_id) WHERE own_preset.preset_id={0}".format(preset_id))[0]
        preset_data['creation_time'] = str(preset_data['creation_time'])

        return str(preset_data)
