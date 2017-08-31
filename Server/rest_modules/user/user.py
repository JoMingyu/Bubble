from flask_restful import Resource
from flask import request

from support.mysql import query
from support.mongo import db


class MyPage(Resource):
    def post(self):
        _id = request.form['id']


class MyPageDetail(Resource):
    def post(self):
        _id = request.form['id']
