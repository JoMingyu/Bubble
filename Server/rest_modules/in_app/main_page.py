from flask_restful import Resource
from flask import request

from support.mysql import query
from support.mongo import db


class MainPage(Resource):
    def get(self):
        # 메인페이지 가져오기
        pass
