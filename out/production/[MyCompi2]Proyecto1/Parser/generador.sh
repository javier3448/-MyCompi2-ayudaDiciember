function pause(){
   read -p "$*"
}


java -jar /home/jonathan/IdeaProjects/CompiFogueo/lib/jflex-full-1.7.0.jar scannerSpecification.jflex --encoding utf-8

pause '\nPress [Enter] key to continue...\n'

java -jar /home/jonathan/IdeaProjects/CompiFogueo/lib/java-cup-11b.jar  -parser parser -symbols sym  parserSpecification.cup



