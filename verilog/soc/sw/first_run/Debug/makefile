################################################################################
# Automatically-generated file. Do not edit!
################################################################################

ifdef COMSPEC
SHELL := ${COMSPEC}
else ifdef ComSpec
SHELL := ${ComSpec}
else
SHELL := cmd.exe
endif

-include ../makefile.init

RM := del

# All of the sources participating in the build are defined here
-include sources.mk
-include subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
endif

-include ../makefile.defs

# Add inputs and outputs from these tool invocations to the build variables 
EXECUTABLES += \
first_run \

BINARY_OUTPUTS += \
first_run.vh \


# All Target
all: first_run secondary-outputs

# Tool invocations
first_run: $(OBJS) $(USER_OBJS)
	@echo 'Building target: $@'
	@echo 'Invoking: Sourcery CodeBench C Linker'
	arm-none-eabi-gcc -T C:\modeltech64_10.2c\examples\work\sw\first_run\sections.lds -Xlinker --fix-v4bx -Xlinker -Map="first_run.map" -o "first_run" "@objs.rsp" "@user_objs.rsp" "@libs.rsp"
	@echo 'Finished building target: $@'
	@echo ' '

first_run.vh: $(EXECUTABLES)
	@echo 'Invoking: Sourcery CodeBench Objcopy'
	arm-none-eabi-objcopy -O verilog first_run "first_run.vh"
	@echo 'Finished building: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) $(C_DEPS)$(BINARY_OUTPUTS)$(EXECUTABLES)
	-$(RM) "C:/modeltech64_10.2c/examples/work/sw/first_run/Debug/first_run.o" "C:/modeltech64_10.2c/examples/work/sw/first_run/Debug/start.o"  first_run first_run
secondary-outputs: $(BINARY_OUTPUTS)

.PHONY: all clean dependents
.SECONDARY:

-include ../makefile.targets
