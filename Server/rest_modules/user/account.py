from flask_restful import Resource
from flask import request

from support.mysql import query


class Signup(Resource):
    def post(self):
        # 자체 회원가입
        email = request.form['email']
        _id = request.form['id']
        pw = request.form['pw']
        nickname = request.form['nickname']
        gender = request.form['gender']

        res = query("SELECT * FROM account WHERE email='{0}' OR id='{1}'".format(email, _id))
        if res:
            return '', 204
        else:
            query("INSERT INTO account VALUES('{0}', '{1}', '{2}', '{3}', '{4}')".format(email, _id, pw, nickname, gender))
            return '', 201


class SignIn(Resource):
    def post(self):
        # 로그인
        if request.form['sns'].upper() == 'TRUE':
            email = request.form['email']
            if not query("SELECT * FROM account_sns WHERE email='{0}'".format(email)):
                # 가입 데이터가 없으면
                nickname = request.form['nickname']
                gender = request.form['gender']

                query("INSERT INTO account_sns VALUES('{0}', '{1}', '{2}')".format(email, nickname, gender))

            return '', 200
        else:
            _id = request.form['id']
            pw = request.form['pw']

            if query("SELECT * FROM account WHERE id='{0}' AND pw='{1}'".format(_id, pw)):
                return '', 200
            else:
                return '', 204
