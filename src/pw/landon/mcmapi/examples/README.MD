# MC-Market Ultimate API: Java Wrapper Documentation
All information listed on this page assumes you have already created the Token object and initialised it properly. 

### Alerts
```java
Alerts.list() // List all unread alerts. (string)
Alerts.markAsRead() // Mark all unread alerts as read. (void)
``` 

### Conversations
```java
Conversations.list() // List all unread conversations. (string)
Conversations.start(int recipient_id, String title, String message) // Start a new conversation. (void)
Conversations.listReplies(int conversation_id) // List replies to an unread conversation. (string)
Conversations.reply(int conversation_id, String message) // Reply to a conversation. (void)
```

### Members
```java
Members.self() // Get data about yourself. (string)
Members.modifySelf(String custom_title, String about_me, String signature) // Modify your account information. (void)
Members.getUser(int member_id) // Get data about a user. (string)
Members.listBans() // List recent bans. (string)
Members.listProfilePosts() // List your profile posts. (string)
Members.getProfilePost(int post_id) // Get a specific profile post. (string)
Members.editProfilePost(int post_id, String message) // Edit a specific profile post. (void)
Members.deleteProfilePost(int post_id) // Delete a specific profile post. (void)

// Additionally, I have included methods to get specific information about a user without you needing to parse the getUser() JSON response.
// Method 1
import pw.landon.mcmapi.objects.Member;

Member member = new Member(int member_id);
member.id // Get member's ID. (integer)
member.username // Get member's username. (string)
member.gender // Get member's gender. (string)
member.timezone // Get member's timezone. (string)
member.joinDate // Get a member's join date in epoch time. (long)
member.lastActivityDate // Get a member's last activity date in epoch time. (long)
member.isBanned // Gets a member's banned status. (boolean)
member.isSuspended // Gets a member's suspended status. (boolean)
member.isRestricted // Gets a member's restricted status. (boolean)
member.isDisabled // Gets a member's disabled status. (boolean)
member.posts // Gets a member's post count. (int)
member.resources // Gets a member's resource count. (int)
member.purchases // Gets a member's purchase count. (int)
member.posRep // Get's a member's positive feedback amount. (int)
member.negRep // Get's a member's negative feedback amount. (int)
member.neutralRep // Get's a member's neutral feedback amount. (int)


// Method 2
// This method is a bit faster, as it doesn't require you to make all the API calls to create the member object.
// However, you lose the convienence of storing all data in one object. Either method works, just depends what you need to do.
Member.getID(int member_id) // Get member's ID. (integer)
Member.getUsername(int member_id) // Get member's username. (string)
Member.getGender(int member_id) // Get member's gender. (string)
Member.getTimezone(int member_id) // Get member's timezone. (string)
Member.getJoinDate(int member_id) // Get a member's join date in epoch time. (long)
Member.getLastActivityDate(int member_id) // Get a member's last activity date in epoch time. (long)
Member.getIsBanned(int member_id) // Gets a member's banned status. (boolean)
Member.getIsSuspended(int member_id) // Gets a member's suspended status. (boolean)
Member.getIsRestricted(int member_id) // Gets a member's restricted status. (boolean)
Member.getIsDisabled(int member_id) // Gets a member's disabled status. (boolean)
Member.getPostCount(int member_id) // Gets a member's post count. (int)
Member.getResourceCount(int member_id) // Gets a member's resource count. (int)
Member.getPurchaseCount(int member_id) // Gets a member's purchase count. (int)
Member.getFeedbackPositive(int member_id) // Get's a member's positive feedback amount. (int)
Member.getFeedbackNegative(int member_id) // Get's a member's negative feedback amount. (int)
Member.getFeedbackNeutral(int member_id) // Get's a member's neutral feedback amount. (int)

// NOTE: Some fields, such as Timezone and LastActivityDate can return null of the user has those hidden.

```
