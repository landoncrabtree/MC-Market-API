# MC-Market Ultimate API: Java Wrapper Documentation
All information listed on this page assumes you have already created the Token object and initialised it properly. 
This page is under construction and subject to change.

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

// Additionally, I have included methods that allow you to retrieve specific user data without parsing JSON.
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

// NOTE: Some fields, such as Timezone and LastActivityDate can return null if the user has those hidden.

```

### Resources
```java
Resources.list() // Get a list of recently updated resources. (string)
Resources.listOwned() // Get a list of resources you have posted. (string)
Resources.getResource(int resource_id) // Get a specific resource's data. (string)
Resources.modifyResource(int resource_id, String title, String tag_line, String description) // Modify a resource. (void)
Resources.getDownloads(int resource_id) // Get a list of resource downloads. (string)
Resources.getDownloadsByMember(int resource_id, int member_id) // Get a list of a resource's downloads by a specific user. (string)
Resources.getDownloadsByVersion(int resource_id, int version_id) // Get a list of a resource's downloads by a specific version. (string)
Resources.getLicenses(int resource_id) // Get a list of resource licenses. (string)
Resources.issueLicense(int resource_id, int purchaser_id, long start_date, long end_date, boolean active, String site_url) // Issue a resource license. (void)
Resources.getLicenseByID(int resource_id, int license_id) // Get information about a specific license. (string)
Resources.modifyLicense(int resource_id, int license_id, long start_date, long end_date, boolean active) // Modify a specific license. (void)
Resources.validateLicensePrivate(int resource_id, int purchaser_id) // Checks if license is valid for a specific user. (string)
Resources.validateLicenseShared(int resource_id, int purchaser_id, int nonce, long timestamp) // Checks if license is valid for a specific user. (string)
Resources.getPurchases(int resource_id) // Get a list of resource purchases. (string)
Resources.getPurchaseByID(int resource_id, int purchase_id) // Get information about a specific purchase. (string)
Resources.getReviews(int resource_id) // Get a list of resource reviews. (string)
Resources.getReviewByMember(int resource_id, int member_id) // Get reviews left by a specific member. (string)
Resources.respondToReview(int resource_id, int review_id, String message) // Respond to a review. (void)
Resources.getUpdates(int resource_id) // Get a list of resource updates. (string)
Resources.getLatestUpdate(int resource_id) // Get a resource's latest update. (string)
Resources.getUpdateByID(int resource_id, int update_id) // Get information about a specific update. (string)
Resources.getVersions(int resource_id) // Get a list of resource versions. (string)
Resources.getLatestVersion(int resource_id) // Get a resource's latest version. (string)
Resources.getVersionByID(int resource_id, int version_id) // Get information about a specific version. (string)

// Additionally, I have included methods that allow you to retrieve data without parsing JSON.
// Method 1
import pw.landon.mcmapi.objects.Resource;

Resource resource = new Resource(int resource_id);
resource.versionID // Get the latest version ID. (int)
resource.versionName // Get the latest version name. (string)

// The Resource object also supports the following fields:
resource.id // Get resource's ID. (int)
resource.downloads // Get downloads. (string)
resource.licenses // Get licenses. (string)
resource.updates // Get updates. (string)
resource.versions // Get versions. (string)
resource.reviews // Get reviews. (string)

// Method 2
Resources.getLatestVersionID(int resource_id) // Get the latest version ID. (int)
Resources.getLatestVersionName(int resource_id) // Get the latest version name. (string)

```

### Threads
```java
Threads.list() // List your threads. (string)
Threads.getThread(int thread_id) // Get information about a specific thread. (string)
Threads.listReplies(int thread_id) // Get replies to a specific thread. (string)
Threads.reply(int thread_id, String message) // Reply to a specific thread. (string)
```

### Other Remarks
I have also included some JSON utility methods to conviently convert string output into JSON:
```java
JSONUtilities.convertStringToJson(String string) // Converts a string into Gson's JsobObject. (JsonObject)
```

Please refer to MC-Market's actual documentation on expected output when using these wrapper methods: https://www.mc-market.org/wiki/ultimate-api-v1/. This will give you an idea on what data you can retrieve and parse. 

For example, if you want to get the view count of a specific thread:
```java
String output = Threads.getThread(265820);
JsonObject json = JSONUtilities.convertStringToJSON(output);
int views = json.get("data").getAsJsonObject().get("view_count").getAsInt();
System.out.println(views);

// 11882
```

Or, if you want to loop through JSON data, such as listing all users with a license to your resource:
```java
String output = Resources.getLicenses(8436);
JsonObject json = JSONUtilities.convertStringToJSON(output);
JsonArray array = json.getAsJsonArray("data");
for (JsonElement license : array) {
    JsonObject obj = license.getAsJsonObject();
    boolean active = obj.get("active").getAsBoolean();
    int purchaserId = obj.get("purchaser_id").getAsInt();
    if (active) {
        String username = Members.getUsername(purchaserId);
        System.out.println(username);
    }
}
```
