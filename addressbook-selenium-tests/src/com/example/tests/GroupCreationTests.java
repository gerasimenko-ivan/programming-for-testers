package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "test-group-4";
    group.header = "HEADER\ntest-group-4";
    group.footer = "FOOTER\ntest-group-4";
	app.groupHelper.fillGroupForm(app, this, group);
    app.groupHelper.submitGroupForm();
    app.groupHelper.returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
	app.groupHelper.fillGroupForm(app, this, new GroupData("", "", ""));
    app.groupHelper.submitGroupForm();
    app.groupHelper.returnToGroupsPage();
  }
}
