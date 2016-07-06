LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := libpatchtl
LOCAL_SRC_FILES  := com_tttony3_testupdate_PatchUtil.c

LOCAL_LDLIBS := -lz -llog
include $(BUILD_SHARED_LIBRARY)