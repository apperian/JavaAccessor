# FILE: Makefile
#
# Copyright (C) 2015 by Apperian.  All rights reserved.
#

CC=gcc
JDK=/usr/java/jdk

SRC      =  $(abspath $(lastword $(MAKEFILE_LIST))/..)
BUILD    =  $(abspath $(SRC)/..)
OUT      =  $(BUILD)/libs
OBJ      =  $(BUILD)/obj
CFLAGS   =  -g -c -Wall -std=c99 -fPIC
INCLUDES =  -I$(JDK)/include -I$(JDK)/include/linux
LDFLAGS  =  -shared

SOURCES  =  $(wildcard $(SRC)/*.c)
OBJECTS  = $(SOURCES:$(SRC)/%.c=$(OBJ)/%.o)
TARGET   = libaccessor.so

all: $(TARGET)
	
$(TARGET): $(OBJECTS) | $(OUT)/.d
	$(CC) $(LDFLAGS) $(OBJECTS) -o $(OUT)/$@

$(OBJECTS): $(OBJ)/%.o : $(SRC)/%.c | $(OBJ)/.d
	$(CC) $(CFLAGS) $(INCLUDES) $< -o $@

%.d:
	@mkdir -p $(dir $@)
	@touch $(dir $@)

clean:
	$(RM) $(OUT)/$(TARGET)
	$(RM) $(OBJ)/*.o
	
#
# EOF: Makefile