from flask_restful import Resource
from flask import request

from support.mysql import query
from support.account_manager import  get_account_data_from_email


class MyPage(Resource):
    # 마이페이지 들어가기
    def get(self):
        email = request.args['email']

        preset_data = query("SELECT * FROM own_preset JOIN preset USING(preset_id) WHERE own_preset.owner='{0}'".format(email))

        created_preset = 0
        uploaded_preset = 0
        downloaded_preset = 0
        like = 0
        download = 0

        for preset in preset_data:
            if preset['poss'] == 1:
                # 지가 만듬
                if preset['uploaded'] == 1:
                    # 지가 만들었고 업로드함
                    created_preset += 1
                    uploaded_preset += 1
                    like += preset['like_count']
                    download += preset['download_count']
                else:
                    # 지가 만들었는데 업로드 안함
                    created_preset += 1
            else:
                # 다운로드임
                downloaded_preset += 1

        acc_data = get_account_data_from_email(email)

        response = {
            'nickname': acc_data['nickname'],
            'date': str(acc_data['signup_date']),
            'mileage': acc_data['mileage'],
            'created_preset': created_preset,
            'uploaded_preset': uploaded_preset,
            'downloaded_preset': downloaded_preset,
            'like': like,
            'download': download
        }

        return response
