from flask_restful import Resource
from flask import request

from support.mysql import query

import json


class MyPage(Resource):
    # 사이드바
    def post(self):
        email = request.form['email']


class MyPageDetail(Resource):
    # 마이페이지 들어가기
    def post(self):
        email = request.form['email']

        preset_data = query("SELECT * FROM own_preset WHERE owner='{0}'".format(email))

        # type 1 : 내가 만들었는데 안 업로드
        # type 2 : 내가 만들었는데 업로드
        # type 3 : 다운로드
        created_preset = 0
        uploaded_preset = 0
        downloaded_preset = 0
        like = 0
        download = 0

        for preset in preset_data:
            if preset['type'] == 1:
                created_preset += 1
            elif preset['type'] == 2:
                created_preset += 1
                uploaded_preset += 1
            else:
                downloaded_preset += 1

            if not preset['type'] == 3:
                like += preset['like_count']
                download += preset['download_count']

        acc_data = query("SELECT * FROM account WHERE email='{0}'".format(email))
        if not acc_data:
            acc_data = query("SELECT * FROM account_sns WHERE email='{0}'".format(email))

        response = {
            'nickname': acc_data[0]['nickname'],
            'date': str(acc_data[0]['signup_date']),
            'mileage': acc_data[0]['mileage'],
            'created_preset': created_preset,
            'uploaded_preset': uploaded_preset,
            'downloaded_preset': downloaded_preset,
            'like': like,
            'download': download
        }

        return json.dumps(response)
