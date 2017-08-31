from flask_restful import Resource
from flask import request

from support.mysql import query
from support.mongo import db


class Signup(Resource):
    def post(self):
        _id = request.form['id']
        pw = request.form['pw']
        nickname = request.form['nickname']

        res = query("SELECT * FROM account WHERE id='{0}'".format(_id))
        if res:
            return '', 204
        else:
            query("INSERT INTO account VALUES('{0}', '{1}', '{2}')".format(_id, pw, nickname))
            return '', 201


class SignIn(Resource):
    def post(self):
        pass
