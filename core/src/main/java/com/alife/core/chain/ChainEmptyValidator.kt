package com.alife.core.chain

sealed interface ChainEmptyValidator {

    class OneModel<I, R>(
        private val first: ChainHandler.Base<I, R>,
        private val second: ChainHandler.Base<I, R>,
    ) : ChainHandler.Base<I, R> {

        override fun handle(inputModel: I): ChainStates<R> {
            return when (val chainState = first.handle(inputModel)) {
                is ChainStates.Success -> second.handle(inputModel)
                is ChainStates.Fail -> chainState
            }
        }
    }

//    class OnEachNewState<I, R>(
//        private val first: ChainHandler.Base<I, R>,
//        private val second: ChainHandler.Base<R, R>,
//    ) : ChainHandler.Base<I, R> {
//
//        override fun handle(inputModel: I): ChainStates<R> {
//            return when (val chainState = first.handle(inputModel)) {
//                is ChainStates.Success -> second.handle(chainState.inputModel)
//                is ChainStates.Fail -> chainState
//            }
//        }
//    }

}