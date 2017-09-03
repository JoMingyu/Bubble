from support.mysql import query


def get_account_data_from_email(email):
    acc_data = query("SELECT * FROM account WHERE email='{0}'".format(email))
    if not acc_data:
        acc_data = query("SELECT * FROM account_sns WHERE email='{0}'".format(email))

    return acc_data[0]
