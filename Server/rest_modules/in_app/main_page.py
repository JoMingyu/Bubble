from flask_restful import Resource
from flask import request

from support.mysql import query


class MainPage(Resource):
    def get(self):
        email = request.form['email']
