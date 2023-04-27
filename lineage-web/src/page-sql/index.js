import React,{ useState, useEffect } from 'react'
import { Outlet, Link, useParams, useNavigate } from 'react-router-dom'
import { Breadcrumb } from 'antd'
import axios from 'axios'
// import { SaveOutlined, FormatPainterOutlined, ExpandOutlined, BranchesOutlined } from '@ant-design/icons';
// import * as monaco from "monaco-editor"
import Monaco from 'react-monaco-editor'
import LeftBox from './job-sql'
import RinghtBox from './right-box'
// import { encode, decode } from '../common/utils'
import { Base64 } from 'js-base64'

import './index.css'


const Page = () => {
  const { id:taskId } = useParams()
  const [taskDetail, setTaskDetail] = useState({})
  const [lineageGraph, setLineageGraph] = useState({'nodes': [], 'links': []})


  const [value, setValue] = useState([
    '"use strict";',
    "function Person(age) {",
    "	if (age) {",
    "		this.age = age;",
    "	}",
    "}",
    "Person.prototype.getAge = function () {",
    "	return this.age;",
    "};",
  ]
  .join("\n")
  );

  // console.log('taskSource----',Base64.decode(taskSource))


  const getDetail = async () => {
    try {
      const res = await axios.get(`tasks/${taskId}`);
        setLineageGraph(res.data.data.lineageGraph)
        setTaskDetail(res.data.data)
        // console.log('result---',res.data.data.lineageGraph)
    } catch (e) {
    
    } finally {
    }
  };

  // useEffect(() => {
  //   // setValue(Base64.decode(taskSource).split(','))
  // }, [taskSource])

  useEffect(() => {
    taskId && getDetail();
  }, [taskId])

  // analysis SQL
  // const analysisSql = () => {
  //   console.log('-----analysisSql-----')
  //   // axios.post(`/tasks/${taskId}/lineage`)
  //   axios.post(`/tasks/1/lineage`)
  // }
  return (
    <div className="main-wrapper FBH FBJ">
      {/* editor */}
      {/* <LeftBox 
        data={taskDetail} 
        analysisSql={analysisSql}
      /> */}
      <Outlet />
      {/* lineage */}
      <div className='right-box'>
        <RinghtBox data={lineageGraph} />
      </div>
     
    </div>
  )
}
export default Page