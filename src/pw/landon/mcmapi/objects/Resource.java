// Copyright (c) 2021 Landon Crabtree [me@landon.pw]
// MIT License (LICENSE.TXT)

package pw.landon.mcmapi.objects;

import pw.landon.mcmapi.wrappers.Resources;

public class Resource {
    public Integer id;
    public String downloads;
    public String licenses;
    public String updates;
    public String versions;
    public String reviews;
    public Integer versionID;
    public String versionName;

    public Resource(Integer id) {
        this.id = id;
        this.downloads = Resources.getDownloads(id);
        this.licenses = Resources.getLicenses(id);
        this.updates = Resources.getUpdates(id);
        this.versions = Resources.getVersions(id);
        this.reviews = Resources.getReviews(id);
        this.versionID = Resources.getLatestVersionID(id);
        this.versionName = Resources.getLatestVersionName(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void issueLicense(int purchaser_id, long start_date, long end_date, boolean active, String site_url) {
        Resources.issueLicense(this.id, purchaser_id, start_date, end_date, active, site_url);
    }

    public void modifyLicense(int license_id, long start_date, long end_date, boolean active) {
        Resources.modifyLicense(this.id, license_id, start_date, end_date, active);
    }
}
