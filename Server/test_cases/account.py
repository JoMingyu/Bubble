import unittest
from main import app
from support.mysql import query


class AccountTest(unittest.TestCase):
    def setUp(self):
        self.client = app.test_client()
        query('DELETE FROM account')

    def tearDown(self):
        query('DELETE FROM account')

    def test(self):
        rv = self.client.post('/signup', data={
            'id': 'test',
            'pw': 'asdfasdf',
            'nickname': '조밍규'
        })
        self.assertEqual('201 CREATED', rv.status)

        rv = self.client.post('/signup', data={
            'id': 'test',
            'pw': 'asdfasdf',
            'nickname': '조밍규'
        })
        self.assertEqual('204 NO CONTENT', rv.status)

        rv = self.client.post('/signin', data={
            'id': 'test',
            'pw': 'asdfasdf'
        })
        self.assertEqual('200 OK', rv.status)

        rv = self.client.post('/signin', data={
            'id': 'another',
            'pw': 'asdfasdf',
            'nickname': '조밍규'
        })
        self.assertEqual('204 NO CONTENT', rv.status)


if __name__ == '__main__':
    unittest.main()
