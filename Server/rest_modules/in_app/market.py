from flask_restful import Resource
from flask import request

from support.mysql import query
from support.account_manager import get_account_data_from_email


class Market(Resource):
    def get(self):
        # 마켓 리스트 데이터
        if 'filter' in request.form:
            filter_hashtag = request.form['hashtag']

            response = list()
            preset_data = query("SELECT preset_id, title, download_count, owner, upload_date, hashtags, image_name FROM market JOIN preset USING(preset_id)")
            for index in range(len(preset_data)):
                # preset 데이터 전체 순회
                preset = preset_data[index]
                if filter_hashtag in preset['hashtags']:
                    # 해시태그 들어있는 경우
                    nickname = get_account_data_from_email(preset['owner'])['nickname']

                    del preset['owner']
                    preset['nickname'] = nickname
                    preset['upload_date'] = str(preset['upload_date'])

                    response.append(preset)

            return response
        else:
            market_data = query("SELECT title, upload_date, is_free FROM market JOIN preset USING(preset_id)")
            for index in range(len(market_data)):
                market_data[index]['upload_date'] = str(market_data[index]['upload_date'])

            return market_data

    def post(self):
        # 마켓에 업로드
        preset_id = request.form['preset_id']
        is_free = request.form['is_free'].upper() == 'TRUE'
        query("UPDATE preset uploaded=1 WHERE preset_id={0}".format([preset_id]))
        query("INSERT INTO market VALUES({0}, CURDATE, {1})".format(preset_id, is_free))

        return '', 201

    def delete(self):
        # 마켓에서 제거
        preset_id = request.form['preset_id']
        query("UPDATE preset uploaded=0 WHERE preset_id={0}".format([preset_id]))
        query("DELETE FROM market WHERE preset_id={0}".format(preset_id))

        return '', 200


class Download(Resource):
    def get(self):
        # 마켓에서 프리셋 다운로드
        email = request.args['email']
        preset_id = request.args['preset_id']
        query("INSERT INTO own_preset VALUES({0}, '{1}', CURDATE(), {2})".format(email, preset_id, 0))
        # 데이터 주는 구문 필요

        return '', 200


class Like(Resource):
    def post(self):
        # 프리셋에 좋아요
        preset_id = request.form['preset_id']
        email = request.form['email']

        acc_data = query("SELECT gender FROM account WHERE email='{0}'".format(email))
        if not acc_data:
            acc_data = query("SELECT gender FROM account_sns WHERE email='{0}'".format(email))

        if acc_data[0]['gender'].upper() == 'M':
            # 남자가 좋아요 누름
            male_like_count = query("SELECT male_like_count FROM preset WHERE preset_id={0}".format(preset_id))[0]['male_like_count']
            query("UPDATE preset SET male_like_count={0} WHERE preset_id={1}".format(male_like_count + 1, preset_id))
        else:
            # 여자가 좋아요 누름
            male_like_count = query("SELECT female_like_count FROM preset WHERE preset_id={0}".format(preset_id))[0]['female_like_count']
            query("UPDATE preset SET female_like_count={0} WHERE preset_id={1}".format(male_like_count + 1, preset_id))

        return '', 201
