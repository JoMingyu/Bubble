from flask_restful import Resource
from flask import request

from support.mysql import query


class Preset(Resource):
    def get(self):
        # '내 프리셋' 데이터 가져오기
        # return list(preset_col.find({'email': request.form['email']}, {'_id': False}))

    def post(self):
        # '내 프리셋'에 추가
        data = {

        }

        # preset_col.insert(data)


class UploadedPreset(Resource):
    def get(self):
        # '내 프리셋' 중 업로드된 데이터 가져오기
        pass


class PresetDetail(Resource):
    def get(self):
        # 프리셋 세부 정보
        pass
