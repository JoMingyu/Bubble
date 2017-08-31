from flask_restful import Resource
from flask import request

from support.mysql import query


class MyPage(Resource):
    # 사이드바
    def post(self):
        _id = request.form['id']


class MyPageDetail(Resource):
    # 마이페이지 들어가기
    def post(self):
        _id = request.form['id']
