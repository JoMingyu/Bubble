from flask_restful import Resource
from flask import request, send_from_directory

from support.mysql import query
import uuid


class PresetImage(Resource):
    def post(self):
        # 프리셋 대표 이미지 업로드
        preset_id = request.form['preset_id']
        f = request.files['image']
        filename = uuid.uuid4()

        query("UPDATE preset SET image_name='{0}' WHERE preset_id={1}".format(filename, preset_id))
        f.save("images/{0}.png".format(filename))

        return '', 201

    def get(self):
        # 대표 이미지 다운로드
        preset_id = request.args['preset_id']
        filename = query("SELECT image_name FROM preset WHERE preset_id={0}".format(preset_id))[0]['image_name']

        return send_from_directory('images/', '{0}.png'.format(filename))


class ProfileImage(Resource):
    def post(self):
        # 프로필 사진 업로드
        email = request.form['email']
        f = request.files['image']
        filename = uuid.uuid4()

        if query("SELECT * FROM account WHERE email='{0}'".format(email)):
            query("UPDATE account SET profile_image_name='{0}' WHERE email='{1}'".format(filename, email))
        else:
            query("UPDATE account_sns SET profile_image_name='{0}' WHERE email='{1}'".format(filename, email))

        f.save("profile_images/{0}.png".format(filename))

        return '', 201

    def get(self):
        # 대표 이미지 다운로드
        email = request.args['email']

        acc_data = query("SELECT * FROM account WHERE email='{0}'".format(email))
        if not acc_data:
            acc_data = query("SELECT * FROM account_sns WHERE email='{0}'".format(email))

        filename = acc_data[0]['profile_image_name']

        return send_from_directory('profile_images/', '{0}.png'.format(filename))
