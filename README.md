### Hexlet tests and linter status:
[![Actions Status](https://github.com/Zenjo93/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/Zenjo93/java-project-71/actions)
[![Java CI](https://github.com/Zenjo93/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Zenjo93/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/1c233686b05600b5c319/maintainability)](https://codeclimate.com/github/Zenjo93/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/1c233686b05600b5c319/test_coverage)](https://codeclimate.com/github/Zenjo93/java-project-71/test_coverage)
# Hexlet Project #2: "Diff Generator"

## How to install
For installing: clone repo to your computer and run ```make run-dist``` from /app directory

## Description
You can use program like CLI utility via ```./build/install/app/bin/app``` command in terminal or like import package: 
``` java
import hexlet.code.Differ;

var diff = Differ.generate(filePath1, filePath2);
System.out.println(diff);
```

### For help<br>
Type `make help` or `./build/install/app/bin/app -h`<br>
<details>
<summary>Example:</summary>

![img_1.png](screenshots/help.png)
</details>

### Stylish format
For stylish format output type: ```./build/install/app/bin/app -f stylish <file1> <file2>``` <br>
Also stylish format is  using by default <br>
<details>
<summary>Example:</summary>

![img.png](screenshots/stylish.png)
</details>

### Plain format
For plain format output type: ```./build/install/app/bin/app -f plain <file1> <file2>``` <br>
<details>
<summary>Example:</summary>

![img.png](screenshots/plain.png)
</details>


### Json format
For json format output type: ```./build/install/app/bin/app -f json <file1> <file2>``` <br>
<details>
<summary>Example:</summary>

![img.png](screenshots/json.png)
</details>
