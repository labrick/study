################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../first_run.c 

S_UPPER_SRCS += \
../start.S 

OBJS += \
./first_run.o \
./start.o 

C_DEPS += \
./first_run.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: Sourcery CodeBench C Compiler'
	arm-none-eabi-gcc -I"C:\modeltech64_10.2c\examples\work\sw" -I"C:\modeltech64_10.2c\examples\work\sw\first_run" -O0 -g -Wall -c -fmessage-length=0 -march=armv2a -mno-thumb-interwork -fno-common -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

%.o: ../%.S
	@echo 'Building file: $<'
	@echo 'Invoking: Sourcery CodeBench Assembler'
	arm-none-eabi-gcc -x assembler-with-cpp -c -march=armv2a -mno-thumb-interwork -g -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


