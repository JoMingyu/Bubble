from flask_restful import Resource
from flask import request

from support.mysql import query


class Market(Resource):
    def get(self):
        # 마켓 리스트 데이터
        pass

    def post(self):
        # 마켓에 업로드
        preset_id = request.form['preset_id']
        query("UPDATE own_preset type=2 WHERE preset_id={0}".format([preset_id]))
        query("INSERT INTO market VALUES({0}, CURDATE)".format(preset_id))

    def delete(self):
        # 마켓에서 제거
        preset_id = request.form['preset_id']
        query("UPDATE own_preset type=1 WHERE preset_id={0}".format([preset_id]))
        query("DELETE FROM market WHERE preset_id={0}".format(preset_id))


class Download(Resource):
    def get(self):
        # 마켓에서 프리셋 다운로드
        email = request.args['email']
        preset_id = request.args['preset_id']
        query("INSERT INTO own_preset VALUES({0}, '{1}', '{2}' ")
        # 데이터 주는 구문 필요


class Like(Resource):
    def post(self):
        pass
