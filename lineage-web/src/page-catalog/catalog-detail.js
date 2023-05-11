import React,{useState, useEffect} from 'react'
import DetailTree from './detail-tree'
import DetailTableInfo from './detail-table-info'
import DetailFunctionInfo from './detail-function-info'

const Cm = () => {
  return (
    <div className='FBH FBJ'>
      <DetailTree />
      <DetailTableInfo />
      {/* <DetailFunctionInfo /> */}
    </div>
  )
}
export default Cm