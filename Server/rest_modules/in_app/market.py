from flask_restful import Resource
from flask import request

from support.mysql import query
from support.mongo import db


class Market(Resource):
    def post(self):
        pass


class Download(Resource):
    def post(self):
        pass
