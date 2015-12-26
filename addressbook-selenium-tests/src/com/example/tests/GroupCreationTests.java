package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "test-group-4";
    group.header = "HEADER\ntest-group-4";
    group.footer = "FOOTER\ntest-group-4";
	app.fillGroupForm(this, group);
    app.submitGroupForm();
    app.returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
	app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupForm();
    app.returnToGroupsPage();
  }
}
