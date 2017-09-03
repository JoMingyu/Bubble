from flask_restful import Resource

from support.mysql import query
import json


class MainPage(Resource):
    def get(self):
        ranking_data = {
            'male_ranker': query("SELECT preset_id, title FROM preset ORDER BY male_like_count DESC")[0],
            'female_ranker': query("SELECT preset_id, title FROM preset ORDER BY female_like_count DESC")[0],
            'download_ranker': query("SELECT preset_id, title FROM preset ORDER BY download_cont DESC")[0],
        }
        preset_datas = query("SELECT preset_id, male_like_count, female_like_count FROM preset")
        max_like_preset_data = dict()
        random_hashtags = list()

        for index in range(len(preset_datas)):
            random_hashtags.append(json.loads(preset_datas[index]['hash_tags']))

            if max_like_preset_data['like_count'] < preset_datas[index]['male_like_count'] + preset_datas[index]['female_like_count']:
                max_like_preset_data['preset_id'] = preset_datas[index]['preset_id']
                max_like_preset_data['title'] = preset_datas[index]['title']
                max_like_preset_data['like_count'] = preset_datas[index]['male_like_count'] + preset_datas[index]['female_like_count']

        random_hashtags = list(set(random_hashtags))
        del max_like_preset_data['like_count']

        ranking_data.update(max_like_preset_data)
        ranking_data.update({'hashtags': random_hashtags})

        return ranking_data
