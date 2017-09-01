from flask import Flask
from flask_restful import Api

from rest_modules.in_app. main_page import MainPage
from rest_modules.in_app. market import Market, Download
from rest_modules.in_app. preset import Preset, PresetDetail, UploadedPreset

from rest_modules.user. user import MyPage
from rest_modules.user. account import Signup, SignIn
from rest_modules.user .account_find import FindIdDemand, FindIdVerify, FindPwDemand, FindPwVerify, ChangePassword

app = Flask(__name__)
api = Api(app)

api.add_resource(Signup, '/signup')
api.add_resource(SignIn, '/signin')

api.add_resource(FindIdDemand, '/find_id/demand')
api.add_resource(FindIdVerify, '/find_id/verify')
api.add_resource(FindPwDemand, '/find_pw/demand')
api.add_resource(FindPwVerify, '/find_pw/verify')
api.add_resource(ChangePassword, '/change_password')

api.add_resource(MyPage, '/mypage')

api.add_resource(MainPage, '/mainpage')
api.add_resource(Market, '/market')
api.add_resource(Download, '/market/download')

api.add_resource(Preset, '/preset')
api.add_resource(UploadedPreset, '/preset/uploaded')
api.add_resource(PresetDetail, '/preset/detail')


if __name__ == '__main__':
    app.run(debug=True, port=4290)
