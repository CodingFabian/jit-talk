# Slides and code for my German Talk about JIT and JITWatch

You will find the slides in `src/main/resources` as plain text files in German.

The demo code is located in `src/main/java`, and the whole project is generated and run by Maven.
The JMH benchmarks require a generation run first:
`mvn clean install && java -jar target/benchmarks.jar -i 5 -wi 5 -f 1 ".*"`

# License
This work is publised under a [Creative Commons Attribution-ShareAlike 4.0 International Public License](LICENSE.md). I assume the "slides" and "code" alone do little for you without my talking, but if you want to use an example "as-is", please reference me and allow others to reuse your examples as well.
I am not applying any specific "code-license" because I think it is unlikely anybody would want to use this code as library :-)

The markdown version of the license file was kindly created by [idleberg](https://github.com/idleberg/Creative-Commons-Markdown).
