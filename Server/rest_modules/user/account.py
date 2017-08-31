from flask_restful import Resource
from flask import request
import uuid

from support.mysql import query


class Signup(Resource):
    def post(self):
        # 회원가입
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
        # 로그인
        _id = request.form['id']
        pw = request.form['pw']

        res = query("SELECT * FROM account WHERE id='{0}' AND pw='{1}'".format(_id, pw))
        if res:
            return '', 200
        else:
            return '', 204


class FindPassword(Resource):
    def post(self):
        # 비밀번호 찾기
        _id = request.form['id']

        res = query("SELECT * FROM account WHERE id='{0}'".format(_id))
        if res:
            # id 존재함
            new_pw = str(uuid.uuid4())[:8]
            query("UPDATE account SET pw='{0}' WHERE id='{1}'".format(new_pw, _id))

            return new_pw, 200

        else:
            return '', 204
