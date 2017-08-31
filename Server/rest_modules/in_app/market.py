from flask_restful import Resource
from flask import request

from support.mysql import query
from support.mongo import db


class Market(Resource):
    def get(self):
        # 마켓 리스트 데이터
        pass

    def post(self):
        # 마켓에 업로드
        pass


class Download(Resource):
    def get(self):
        # 마켓에서 프리셋 다운로드
        pass
