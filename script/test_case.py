from requests import Session



session = Session()

# HEAD requests ask for *just* the headers, which is all you need to grab the
# session cookie
session.head('http://localhost:8080/ServletDB')

print 'TEST LOGIN IN'

response = session.post(
    url='http://localhost:8080/ServletDB/login.action',
    data={
        'username': 'admin',
        'password': 'admin',
    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)

if (response.url == 'http://localhost:8000/ServletDB/A_Book.jsp '):
    print 'login test passed'
else:
    print 'login test failed'

print ''

print 'DB TEST_CASE1:'
print 'add a new item into database'


response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'insert',
        'isbn': 'test',
        'author_name': 'test',
        'book_name': 'test',
        'category': 'NOVEL',
        'price': '2.00',
        
    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)

if (response.content == 'succeed'):
    print 'DB test1 passed'
else:
    print 'DB test1 failed'

print ''
print 'DB TEST_CASE2:'
print 'Add a new item into database again'
print 'It should be fail due to dupilicated primary key.'


response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'insert',
        'isbn': 'test',
        'author_name': 'test',
        'book_name': 'test',
        'category': 'NOVEL',
        'price': '2.00',

    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)
if (response.content.find('failed')>=0 ):
    print 'DB test2 passed'
else:
    print 'DB test2 failed'

print ''

print 'DB TEST_CASE3:'
print 'Find the one we added, one item are expected to be found.'

response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'search',
        'isbn': 'test',

    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)
if (response.content.find('find 1 item(s)')>=0 ):
    print 'DB test3 passed'
else:
    print 'DB test3 failed'

print ''

print 'DB TEST_CASE4:'

print 'Delete the one we found'


response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'delete',
        'isbn': 'test',

    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)
if (response.content.find('succeed')>=0 ):
    print 'DB test4 passed'
else:
    print 'DB test4 failed'

print ''

print 'DB TEST_CASE5:'

print 'Find the one we added again,'
print 'No item should be found as we have deleted such item'


response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'search',
        'isbn': 'test',

    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)
if (response.content.find('failed')>=0 ):
    print 'DB test5 passed'
else:
    print 'DB test5 failed'


print ''

print 'DB TEST_CASE6:'
print "Delete the one we added again"
print "It should be failed as it doesn't exist in database"


response = session.post(
    url='http://localhost:8080/ServletDB/editBook.action',
    data={
        'use': 'delete',
        'isbn': 'test',

    },
    headers={
        'Referer': 'http://localhost:8080/ServletDB'
    }
)
if (response.content.find('failed')>=0 ):
    print 'DB test6 passed'
else:
    print 'DB test6 failed'
