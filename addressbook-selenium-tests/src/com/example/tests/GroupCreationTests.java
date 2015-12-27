package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "test-group-4";
    group.header = "HEADER\ntest-group-4";
    group.footer = "FOOTER\ntest-group-4";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returnToGroupsPage();
  }
}
