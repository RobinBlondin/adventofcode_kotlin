package advent_of_code_2020.day8

import java.io.File

/**
 * Inspired by Kotlin by JetBrains @ YouTube
 *
 * This solution is very clever. It has a MachineState class designed to contain the accumulated index and sum after operations in the inputList.
 * The Instruction class can hold a MachineState and the Nop, Jmp, and Acc classes inherits from Instruction all with a specific MachineState
 * based on the different types of operations in the input.
 *
 * The Instruction method will parse a string from the inputList and create an Instruction object of the right kind, and we use this function
 * to create a list of instructions.
 *
 */

val instructions = File("src/advent_of_code_2020/day8/input.txt").readLines().map { Instruction(it) }
data class MachineState(val index: Int, val acc: Int)
sealed class Instruction(val action: (MachineState) -> MachineState)
class Nop(val value:Int): Instruction( { MachineState(it.index + 1, it.acc) })
class Jmp(val value:Int): Instruction( { MachineState(it.index + value, it.acc)} )
class Acc(val value:Int): Instruction( {MachineState(it.index + 1, it.acc + value)} )

fun Instruction(input: String): Instruction {
    val (operation, value) = input.split(" ")
    return when(operation) {
        "nop" -> Nop(value.toInt())
        "jmp" -> Jmp(value.toInt())
        "acc" -> Acc(value.toInt())
        else -> error("No such operation")
    }
}

fun execute(instructions: List<Instruction>): MachineState {
    var state = MachineState(0, 0)
    val usedInstructions = mutableSetOf<Instruction>()
    while(state.index in instructions.indices) {
        val nextInstruction = instructions[state.index]

        if(usedInstructions.contains(nextInstruction))
            break
        else
            usedInstructions.add(nextInstruction)

        state = nextInstruction.action(state)
    }
    return state
}

fun generateAllMutations(instructions: List<Instruction>): Sequence<List<Instruction>> =
    sequence {
        for((index, instruction) in instructions.withIndex()) {
            val mutatedList = instructions.toMutableList()
            mutatedList[index] = when(instruction) {
                is Jmp -> Nop(instruction.value)
                is Nop -> Jmp(instruction.value)
                is Acc -> continue
            }
            yield(mutatedList)
        }
    }

fun main() {
    println(execute(instructions).acc)
    println(
        generateAllMutations(instructions)
            .map { mutatedList -> execute(mutatedList) }
            .first { state -> state.index !in instructions.indices }.acc
    )
}

