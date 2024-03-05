package advent_of_code_2020.day8

import java.io.File

/**
 * Inspired by Kotlin by JetBrains @ YouTube
 *
 * I chose this solution because of the interesting use of classes and state. But the one thing that caught my eye
 * were once again the use of sequence. How in part 2 it creates a sequence of every of mutation of the list which
 * can be used whenever or however. Very clever.
 */

val instructions = File("src/advent_of_code_2020/day8/input.txt").readLines().map { Instruction(it) }
data class MachineState(val index: Int, val acc: Int)
sealed class Instruction(val action: (MachineState) -> MachineState)
class Nop(val value:Int): Instruction({ MachineState(it.index + 1, it.acc) })
class Jmp(val value:Int): Instruction({ MachineState(it.index + value, it.acc) })
class Acc(val value:Int): Instruction({ MachineState(it.index + 1, it.acc + value) })

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

