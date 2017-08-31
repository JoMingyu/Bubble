from pymongo import MongoClient

client = MongoClient('localhost', 27107)

db = client.bubble

statistic_col = db.statistic
market_col = db.market
preset_col = db.preset
