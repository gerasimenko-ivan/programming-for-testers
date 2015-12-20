package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "test-group-4";
    group.header = "HEADER\ntest-group-4";
    group.footer = "FOOTER\ntest-group-4";
	fillGroupForm(group);
    submitGroupForm();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
	fillGroupForm(new GroupData("", "", ""));
    submitGroupForm();
    returnToGroupsPage();
  }
}
