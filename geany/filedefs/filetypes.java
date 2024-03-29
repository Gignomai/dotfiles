[build-menu]
FT_00_LB=_Compila
FT_00_CM=/home/manel/.sdkman/candidates/java/current/bin/javac "%f"
FT_00_WD=
EX_00_LB=_Executa
EX_00_CM=/home/manel/.sdkman/candidates/java/current/bin/java "%e"
EX_00_WD=


# For complete documentation of this file, please see Geany's main documentation
[styling=C]

[keywords]
primary=abstract assert break case catch class const continue default do else enum extends final finally for goto if implements import instanceof interface native new package private protected public return static strictfp super switch synchronized this throw throws transient try volatile while true false null
secondary=boolean byte char double float int long short void List String Map ArrayList HashMap
# documentation keywords for javadoc
doccomment=author deprecated exception param return see serial serialData serialField since throws todo version
typedefs=

[lexer_properties=C]

[settings]
# default extension used when saving files
extension=java

# MIME type
mime_type=text/x-java

# the following characters are these which a "word" can contains, see documentation
#wordchars=_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789

# single comments, like # in this file
comment_single=//
# multiline comments
comment_open=/*
comment_close=*/

# set to false if a comment character/string should start at column 0 of a line, true uses any
# indentation of the line, e.g. setting to true causes the following on pressing CTRL+d
	#command_example();
# setting to false would generate this
#	command_example();
# This setting works only for single line comments
comment_use_indent=true

# context action command (please see Geany's main documentation for details)
context_action_cmd=

[indentation]
#width=4
# 0 is spaces, 1 is tabs, 2 is tab & spaces
#type=1

[build_settings]
# %f will be replaced by the complete filename
# %e will be replaced by the filename without extension
# (use only one of it at one time)
compiler=javac "%f"
run_cmd=java "%e"
