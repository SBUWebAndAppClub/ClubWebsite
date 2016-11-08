#Security branch
I played around a little with security and got some basic functionality working.
It's not complete and many features are missing like creating accounts and letting admins view/edit/delete all users. Can't logout yet either.
Currently, to login you must create an account by going to /admin. It will redirect you to the projects page after it creates an account.
Once it's created, you can login by going to /login or trying to access a page that requires admin privileges.

##Missing Features
 - Admin tools (view, delete, etc.)
 - Linkage of accounts to members
 - Logout functions
 - Remember Me checkbox so you don't have to login each time you visit the site. (If you want)
 
##Needs Work
 - Login page (It's really messy)
 - Documentation
 - Code style
 
##Fun Fact
The database doesn't actually know your password. Instead, some hash algorithm is used to create a
string that can not be decoded back into your password. It's also salted.
For more info, look at https://en.wikipedia.org/wiki/Cryptographic_hash_function