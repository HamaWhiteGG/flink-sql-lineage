import React,{useState, useEffect} from 'react'
import {Breadcrumb} from 'antd'

const Cm = () => {
  return (
    <div className='left-tree-box'>
      <Breadcrumb separator="<">
        <Breadcrumb.Item href="#/catalog">Catalogs</Breadcrumb.Item>
        {/* <Breadcrumb.Item>{taskDetail?.taskName || '--'}</Breadcrumb.Item> */}
      </Breadcrumb>
    </div>
  )
}
export default Cm