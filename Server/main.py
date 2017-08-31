from flask import Flask
from flask_restful import Api
from rest_modules.market import Market, Download

from rest_modules.in_app.preset import MyPreset, PresetDetail, UploadedPreset
from rest_modules.user import MyPage, MyPageDetail
from rest_modules.user.account import Signup, SignIn

app = Flask(__name__)
api = Api(app)

api.add_resource(Signup, '/signup')
api.add_resource(SignIn, '/signin')
api.add_resource(Market, '/market')
api.add_resource(Download, '/market/download')
api.add_resource(MyPreset, '/preset/own')
api.add_resource(UploadedPreset, '/preset/uploaded')
api.add_resource(PresetDetail, '/preset/detail')
api.add_resource(MyPage, '/mypage')
api.add_resource(MyPageDetail, '/mypage/detail')


if __name__ == '__main__':
    app.run(debug=True)
