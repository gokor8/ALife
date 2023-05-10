package com.alife.anotherlife.core.ui.state.lce

interface LCEModel {

    interface Loading : LCEModel

    interface Content : LCEModel

    interface Error : LCEModel
}