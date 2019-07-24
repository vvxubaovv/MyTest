package com.xubao.junitTestTest.runWithTest;

import com.xubao.junitTestTest.runWithTest.forCategoryTest.A;
import com.xubao.junitTestTest.runWithTest.forCategoryTest.B;
import com.xubao.junitTestTest.runWithTest.forCategoryTest.Tag1;
import com.xubao.junitTestTest.runWithTest.forCategoryTest.Tag2;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({A.class, B.class})
@Categories.IncludeCategory({Tag1.class, Tag2.class})
public class CategoryTest
{

}

