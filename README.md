# Competitive Programming Gradle Plugin

Java only version of competitive programming toolkit, inspired
by [Source: Manwe56/competitive-programming](https://github.com/Manwe56/competitive-programming)

> **Credit:** `BuildSolutionTask.java`  - [Source: Manwe56](https://github.com/Manwe56/competitive-programming/blob/master/src/main/java/builder/FileBuilder.java)

## Why?

This plugin aims to help in the competitive programming challenges by allowing you to develop in several files with a one click build, and sharing a common set of codes between challenges. Don't reinvent the wheel, focus on the subject! Supports Problem parsing and Junit based test case matching for better testing and debugging.

## Dependency

- JDK 1.8

## Features:

- Parse Problem and generate boilerplate code with  
- Reuse common utility class, avoid writing same core logic (eg. Input Reader, GCD etc)
- Problem parsing with [Competitive Companion](https://github.com/jmerle/competitive-companion)
- Manual input with local server hosted on http://localhost:7373
- Generate a single solution file to be uploaded to platform.
- Support @Entry Annotation for parsing Leetcode problems.

#### Installing Plugin (Currently on jitpack)

Reference `build.gradle`

```build.gradle
plugins {
    // Apply the java plugin to add support for Java
    id 'java'
    // Apply Competitive Programming Plugin
    id 'com.github.saurabh73.competitive-programming' version '1.1.0'
}

sourceCompatibility=1.8
targetCompatibility=1.8

repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
    mavenLocal()
    mavenCentral()
}

test {
    useJUnitPlatform()
}

dependencies {
    // add transitive dependencies for leetcode annotation
    compileClasspath 'com.github.saurabh73.competitive-programming:competitive-programming:1.1.0'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.3.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.3.1'
    testImplementation 'commons-io:commons-io:2.8.0'
}

competitiveProgramming {
    author = "Saurabh Dutta"
    githubUsername = "saurabh73"
    port = "7373"
}
```

### Plugin Configuration

| Property             | Required | Default                          |
| -------------------- | -------- | -------------------------------- |
| author               | yes      |                                  |
| githubUsername       | no       |                                  |
| port                 | no       | 6174                             |
| basePackage          | no       | competitive.programming.practice |
| baseOutputPath       | no       | output                           |
| baseSourcePath       | no       | src/main/java                    |
| baseTestPath         | no       | src/test/java                    |
| baseTestResourcePath | no       | src/test/resources               |
                         
**NOTE:** For any custom port, update custom port in  [Competitive Companion](https://github.com/jmerle/competitive-companion) as well
### Initialize Problem file

Generate Problem Java Files:

Run command:

```shell
./gradlew initProblem
```

Parse problem with [Competitive Companion](https://github.com/jmerle/competitive-companion) 

**Install Links:**

- [**Chrome** extension](https://chrome.google.com/webstore/detail/competitive-companion/cjnmckjndlpiamhfimnnjmnckgghkjbl)
- [**Firefox** add-on](https://addons.mozilla.org/en-US/firefox/addon/competitive-companion/)

**or**

use http://localhost:6174 (or configured port, for manual input eg Leetcode, Hackerearth Codemonk)

![Screenshot](https://res.cloudinary.com/dren4jgbp/image/upload/v1611277157/Screenshot_2021-01-22_Competitive_Programming_Gradle_Plugin_Input_Form_dtzcpo.png)

### Generated Files:

`TwoSum.java`

```java
package platform.leetcode.problem0001;

import base.ISolution;

import java.io.InputStream;

/**
 *
 * @author Saurabh Dutta
 * @see <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a> 
 *
 **/
public class TwoSum implements ISolution {

    @Override
    public void solve(InputStream in) {
        //TODO: Implement Solution
    }
}
```

`TwoSumTest.java`

```java
package platform.leetcode.problem0001;

import base.ISolution;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Test for TwoSum.java
 * @author Saurabh Dutta<saurabh73>
 * @see <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a> 
 *
 **/
public class TwoSumTest {

    private ByteArrayOutputStream buffer;

    @BeforeEach
    public void setup() {
        buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
    }

    @Test
    public void case1Test() throws Exception {
        // Input
        InputStream inputStream = this.getClass().getResourceAsStream("/leetcode/problem0001/input1.txt");
        // Output
        InputStream outPutStream = this.getClass().getResourceAsStream("/leetcode/problem0001/output1.txt");
        // Call Method Under Test
        ISolution problem = new TwoSum();
        problem.solve(inputStream);
        //Assertion
        String actual = buffer.toString().trim();
        String expected = IOUtils.toString(outPutStream, Charset.defaultCharset()).trim();
        assertEquals(expected, actual);
    }

    @Test
    public void case2Test() throws Exception {
        // Input
        InputStream inputStream = this.getClass().getResourceAsStream("/leetcode/problem0001/input2.txt");
        // Output
        InputStream outPutStream = this.getClass().getResourceAsStream("/leetcode/problem0001/output2.txt");
        // Call Method Under Test
        ISolution problem = new TwoSum();
        problem.solve(inputStream);
        //Assertion
        String actual = buffer.toString().trim();
        String expected = IOUtils.toString(outPutStream, Charset.defaultCharset()).trim();
        assertEquals(expected, actual);
    }

    @Test
    public void case3Test() throws Exception {
        // Input
        InputStream inputStream = this.getClass().getResourceAsStream("/leetcode/problem0001/input3.txt");
        // Output
        InputStream outPutStream = this.getClass().getResourceAsStream("/leetcode/problem0001/output3.txt");
        // Call Method Under Test
        ISolution problem = new TwoSum();
        problem.solve(inputStream);
        //Assertion
        String actual = buffer.toString().trim();
        String expected = IOUtils.toString(outPutStream, Charset.defaultCharset()).trim();
        assertEquals(expected, actual);
    }

    @AfterEach
    public void cleanup() {
        buffer.reset();
    }
}
```

#### Build Single Solution File

Run command:

```shell
./gradlew buildSolution -q --console=plain
```

outputs interactive terminal input:

```shell
> Enter class name to execute: platform.leetcode.problem0001.TwoSum
File Path: /workbench/competitive-programming/src/main/java/Solution.java
reading class content of /workbench/competitive-programming/src/main/java/Solution.java
reading class content of /workbench/competitive-programming/coding-problems/src/main/java/base/ISolution.java
Standard import:import java.io.InputStream;
reading class content of /workbench/competitive-programming/coding-problems/src/main/java/platform/leetcode/problem0001/TwoSum.java
OUTPUT PATH : /workbench/competitive-programming/output/Solution.java
Deleting path: /workbench/competitive-programming/src/main/java/Solution.java
```

Generated File: `Solution.java`

```java
import java.io.InputStream;

class Solution {
    private static interface ISolution {
        default int getTimeoutInSeconds() {
            return 2;
        }

        void solve(InputStream in);
    }

    private static class TwoSum implements ISolution {
        @Override
        public void solve(InputStream in) {
        }
    }

    public static void main(String[] args) {
        ISolution solution = new Test();
        solution.solve(System.in);
    }
}
```

Note: The generated source is added to system clipboard (might be buggy in linux
openjdk [Issue](https://bugs.openjdk.java.net/browse/JDK-8179547))

## code layout

- Common utility source code is in the `src/main/java` folder.
- Problem files is generated in `/src/main/java` folder categorized by platforms.
- Junit Test case is generated in `/src/test/java` folder categorized by platforms.
- Default Test input file will be in `src/test/resources/` folder categorized by platforms.
- Solution file is generated in `output` folder.

### Download Example

[competitive-programming-example.zip](https://github.com/saurabh73/competitive-programming-practice/archive/gradle-plugin-example-repo.zip)