LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := accessor.c
LOCAL_CFLAGS 	:= -g -c -Wall -std=c99 -fPIC
LOCAL_MODULE    := accessor

include $(BUILD_SHARED_LIBRARY)