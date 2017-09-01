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

        return {'filename': filename}, 201

    def get(self):
        # 대표 이미지 다운로드
        filename = request.args['filename']
        return send_from_directory('images/', filename)
