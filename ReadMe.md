## function
Firewall application

## proposal
A firewall that checks to make sure a username is not inappropriate. It will be able to handle access to other pages of the site.
The firewall will have authentication capabilities to check credentials of the users.

## user stories
- the user will open the site and have an option to login or sign up
- the user will choose the register option if they do not have an account
    - the user will create login credentials
    - a filter will check to make sure the user does not input inappropriate content
    - the user will be redirected to login after they have created their username/password
- the user will choose login if they already have a username/password for the site
    - the user will input their credentials
    - the application will check to see if they input existing credentials
    - if the username/password don't match anything in the system they will be asked to try again
    - if the user inputs correct credentials then they will be sent to the main page
- the application will monitor that the users wont click on pages too many times in one session
    - if the user goes to the same page more then (5) times during one session they will be blocked from entering again on the session

## process

## database
- the username and passwords can be saved to a database