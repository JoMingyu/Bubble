import pymysql

connection = pymysql.connect(
    host='localhost',
    port=3306,
    user='root',
    password='uursty199',
    db='sw_hackathon_2017',
    charset='utf8'
)


def query(sql):
    cursor = connection.cursor(pymysql.cursors.DictCursor)
    cursor.execute(sql)

    if 'SELECT' in sql.upper():
        return cursor.fetchall()
    else:
        return connection.commit()
