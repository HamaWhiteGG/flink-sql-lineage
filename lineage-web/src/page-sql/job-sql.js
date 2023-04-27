import React,{ useState, useEffect } from 'react'
import { Outlet, Link, useParams, useNavigate } from 'react-router-dom'
import { Breadcrumb, Tooltip } from 'antd'
import { SaveOutlined, FormatPainterOutlined, ExpandOutlined, BranchesOutlined } from '@ant-design/icons';
import Monaco from 'react-monaco-editor'
import "monaco-editor/esm/vs/basic-languages/sql/sql.contribution"
import axios from 'axios'
import { Base64 } from 'js-base64'

const Cm = ({data}) => {
  // const {taskId, taskName, taskSource, database, catalogId} = data
  const { id:taskId } = useParams()
  const [taskDetail, setTaskDetail] = useState({})
  const [lineageGraph, setLineageGraph] = useState({'nodes': [], 'links': []})
  console.log('useParams---',taskId)

  const _initOptions = {
    selectOnLineNumbers: true,
    renderSideBySide: false,
    lineNumbersMinChars: 3, // 最少显示3位长的行号
    lineDecorationsWidth: 20,
    quickSuggestions: true,
    renderLineDecorations: (lineNumber, decorations) => {
      return [
        {
          range: { startLineNumber: lineNumber, endLineNumber: lineNumber },
          options: {
            isWholeLine: true,
            linesDecorationsClassName: "line-decoration",
            overviewRulerLane: monaco.editor.OverviewRulerLane.Left
          }
        }
      ]
    }
  };
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
  )
  const editorWillMount = () => {
    // var decorations = monaco.editor.deltaDecorations(
    //   [],
    //   [
    //     {
    //       range: new monaco.Range(3, 1, 5, 1),
    //       options: {
    //         isWholeLine: true,
    //         linesDecorationsClassName: "myLineDecoration",
    //       },
    //     },
    //     {
    //       range: new monaco.Range(7, 1, 7, 24),
    //       options: { inlineClassName: "myInlineDecoration" },
    //     },
    //   ]
    // );
  
    // monaco.editor.IModelDecorationOptions = {
    //   // firstLineDecorationClassName: "myInlineDecoration",
    //   inlineClassName: "myInlineDecoration",
    //   className: "myLineDecoration",
    //   zIndex: 5,
    //   after: {
    //     linesDecorationsClassName: "myInlineDecoration",
    //   },
    //   stickiness: {
    //     AlwaysGrowsWhenTypingAtEdges: 0
    //   }
    // }
  }
  
  // update job
  const updateJob = () => {
    console.log('-----analysisSql-----')
    axios.put(`/tasks/${taskId}`, {
      source: '',
      taskId,
    })
  }

  const analysisSql = async () => {
    await updateJob()
    axios.post(`/tasks/${taskId}/lineage`)
  }

  const getJobDetail = async (taskId) => {
    try {
      // debugger
      const res = await axios.get(`tasks/${taskId}`)
      setLineageGraph(res.data.data.lineageGraph)
      setTaskDetail(res.data.data)
      setValue(Base64.decode(res?.data?.data?.taskSource))
    } catch (e) {
      
    } finally {
    }
  }

  useEffect(() => {
    getJobDetail(taskId)
  }, [taskId])

  return (
    <div className='left-box'>
      <div className="p16">
        <Breadcrumb separator="<">
          <Breadcrumb.Item href="#/job/list">jobs</Breadcrumb.Item>
          <Breadcrumb.Item>{taskDetail?.taskName || '--'}</Breadcrumb.Item>
        </Breadcrumb>
      </div>
      <div>
        <div className='FBH FBJ pl16 pr16 pt8 pb8 gray-box-deep'>
          <div>
            <Tooltip title="analysis">
              <BranchesOutlined className='mr16 hand' onClick={() => analysisSql()} />
            </Tooltip>
            <SaveOutlined className='mr16' />
            <FormatPainterOutlined className='mr16' />
            <ExpandOutlined />
          </div>
          <div>2/2 </div>
        </div>
        <Monaco 
          height={700}
          value={value}
          language="sql"
          options={_initOptions}
          editorWillMount={editorWillMount}
        />
      </div>
    </div>
  )
}

export default Cm